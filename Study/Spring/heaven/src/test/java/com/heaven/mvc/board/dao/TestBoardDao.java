package com.heaven.mvc.board.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heaven.mvc.board.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/TestBoardDao-context.xml")
public class TestBoardDao {

	@Autowired
	private BoardDao boardDao;

	private List<BoardVO> boardList;

	@Before
	public void setUp() {
		boardDao.deleteAll();
		boardDao.insert(new BoardVO("����1", "����1", "�ۼ���1", 1000));
		boardDao.insert(new BoardVO("����2", "����2", "�ۼ���2", 1111));
		boardDao.insert(new BoardVO("����3", "����3", "�ۼ���3", 2222));

		boardList = boardDao.list();
	}

	@Test
	public void testList() {
		assertThat(boardList.size(), is(3));
		BoardVO dbVO;

		for (int index = 0; index < boardList.size(); index++) {
			dbVO = boardDao.select(boardList.get(index).getSeq());
			compareVO(dbVO, boardList.get(index));
		}
	}

	@Test
	public void testDelete() {
		int seq = boardList.get(0).getSeq();
		boardDao.delete(boardList.get(0));
		boardList = boardDao.list();
		assertThat(boardList.size(), is(2));
		assertThat(boardDao.select(seq), is(nullValue()));
	}

	@Test
	public void testDeleteAll() {
		boardDao.deleteAll();
		boardList = boardDao.list();
		assertThat(boardList.size(), is(0));
	}

	@Test
	public void testUpdate() {
		BoardVO vo = boardList.get(0);
		vo.setTitle("title");
		vo.setContent("context");
		vo.setWriter("writer");

		boardDao.update(vo);
		compareVO(boardDao.select(vo.getSeq()), vo);
	}

	@Test
	public void testInsert() {
		BoardVO vo;
		BoardVO dbVO;

		vo = new BoardVO("����4", "����4", "�ۼ���4", 3333);
		
		int size = boardDao.list().size();
		boardDao.insert(vo);
		
		dbVO = boardDao.select(vo.getSeq());
		vo.setRegDate(dbVO.getRegDate());
		
		assertThat(boardDao.list().size(), is(size + 1));
		compareVO(boardDao.select(vo.getSeq()), vo);
	}

	@Test
	public void testSelect() {
		int index;
		BoardVO dbVO;
		
		index = 0;
		dbVO = boardDao.select(boardList.get(index).getSeq());
		compareVO(dbVO, boardList.get(index));
		
		index = 1;
		dbVO = boardDao.select(boardList.get(index).getSeq());
		compareVO(dbVO, boardList.get(index));
	}

	@Test
	public void testUpdateReadCount() {
		int index;
		int readCount;
		BoardVO dbVO;
		
		index = 0;
		dbVO = boardDao.select(boardList.get(index).getSeq());
		readCount = dbVO.getCnt();
		boardDao.updateReadCount(dbVO.getSeq());
		dbVO = boardDao.select(boardList.get(index).getSeq());
		assertThat(dbVO.getCnt(), is(readCount + 1));
	}

	private void compareVO(BoardVO vo1, BoardVO vo2) {
		assertThat(vo1.getSeq(), is(vo2.getSeq()));
		assertThat(vo1.getTitle(), is(vo2.getTitle()));
		assertThat(vo1.getContent(), is(vo2.getContent()));
		assertThat(vo1.getWriter(), is(vo2.getWriter()));
		assertThat(vo1.getRegDate(), is(vo2.getRegDate()));
		assertThat(vo1.getPassword(), is(vo2.getPassword()));
		assertThat(vo1.getCnt(), is(vo2.getCnt()));

	}
}

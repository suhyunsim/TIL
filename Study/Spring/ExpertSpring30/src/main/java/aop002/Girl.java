package aop002;

public class Girl {
	
	public void runSomething() {
		System.out.println("����� �� ���� �� ����");
		
		try {
			System.out.println("�丮�Ѵ�.");
		} catch (Exception ex) {
			if (ex.getMessage().equals("���� �� ��")) {
				System.out.println("119 �Ű�");
			}
		} finally {
			System.out.println("�ҵ� �� ��ħ");
		}
		System.out.println("�ڹ��� ��װ� �� ������");
	}


}

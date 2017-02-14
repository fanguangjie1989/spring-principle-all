package spring.base.principle.di.xml;

public class NormalKeyHelper implements KeyHelper {

	@Override
	public void openLock() {
		System.out.println("...NormalKeyHelper...openLock");
	}

}

package spring.base.principle.di.xml;

public class NormalLockOpener implements LockOpener {
	private KeyHelper keyHelper;

	public void setKeyHelper(KeyHelper keyHelper) {
		this.keyHelper = keyHelper;
	}


	@Override
	public KeyHelper getKeyHelper() {
		return keyHelper;
	}

	
	@Override
	public void openLock() {
		keyHelper.openLock();
	}

}

package controller;

import javax.naming.NamingException;

import Pipe1.ExampleStatefulBeanRemote;
import Pipe1.ExampleStatelessBeanRemote;

public class ClientSideExample implements ExampleStatefulBeanRemote, ExampleStatelessBeanRemote {

	private final ExampleStatefulBeanRemote stateful;
	private final ExampleStatelessBeanRemote stateless;
	
	public ClientSideExample() throws NamingException {
		stateful = BeanLocator.lookupStatefulBean(ExampleStatefulBeanRemote.class, "ExampleStatefulBean");
		stateless = BeanLocator.lookupStatelessBean(ExampleStatelessBeanRemote.class, "ExampleStatelessBean");
	}
	
	@Override
	public int count() {
		return stateful.count();
	}

	@Override
	public void foo() {
		stateless.foo();
	}

}

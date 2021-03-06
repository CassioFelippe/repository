package br.eti.clairton.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.vidageek.mirror.dsl.Mirror;

public class ModelTest {
	final Aplicacao a = new Aplicacao("a");
	final Aplicacao b = new Aplicacao("b");

	@Test
	public void testHashCode() {
		assertEquals(a.hashCode(), new Aplicacao("a").hashCode());
		assertNotEquals(a.hashCode(), b.hashCode());
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		final Recurso recurso = new Recurso(a, "Teste");
		new Mirror().on(recurso).set().field("id").withValue(1000l);
		final Recurso clone = (Recurso) recurso.clone();
		assertNull(clone.getId());
		assertNull(clone.getAplicacao().getId());
		assertEquals("Teste", clone.getNome());
		assertEquals("a", clone.getAplicacao().getNome());
	}

	@Test
	public void testToString() {
		assertNotEquals(a.toString(), new Aplicacao("a").toString());
		assertEquals(a.toString(), a.toString());
		assertNotEquals(a.toString(), b.toString());
		assertTrue(a.toString().contains("[nome=a,"));
		assertTrue(a.toString().endsWith("id=<null>]"));
		assertTrue(a.toString().startsWith("br.eti.clairton.repository.Aplicacao@"));
	}

	@Test
	public void testEqualsObject() {
		assertFalse(a.equals(b));
		assertFalse(a.equals(null));
		assertFalse(a.equals("Qualquer outro Objeto"));
		assertTrue(a.equals(new Aplicacao("a")));
		assertTrue(a.equals(a));
	}
}

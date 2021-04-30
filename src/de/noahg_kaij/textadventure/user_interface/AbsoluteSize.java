package de.noahg_kaij.textadventure.user_interface;

/**
 * An absolute implementation of ISizeReference
 */
public final class AbsoluteSize implements ISizeReference {

	private final int _size;

	public AbsoluteSize(int size) {
		_size = size;
	}
	
	@Override
	public int getValue(int relativeTo) {
		return _size;
	}

}

package ql2.conflict;

import ql2.conflict.Conflict.Level;

public class InvalidType extends Conflict {

	@Override
	public Level getConflictLevel() {
		return Level.ERROR;
	}
}
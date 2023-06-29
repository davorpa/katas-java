package functional.atm;

import java.util.Optional;

class Option
{
	private final String label;
	private final Optional<Runnable> action;

	public Option(String label, Optional<Runnable> action) {
		this.label = label;
		this.action = action;
	}

	public String getLabel() {
		return label;
	}

	public Optional<Runnable> getAction() {
		return action;
	}
}
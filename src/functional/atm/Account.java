package functional.atm;

import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.DoublePredicate;
import java.util.function.Supplier;

class Account implements Withdrawable, Depositable, FundsAccessor
{
	private final AtomicReference<Double> funds;

	public Account(final double initialFunds) {
		this.funds = new AtomicReference<>(initialFunds);
	}

	@Override
	public void deposit(final double amount) throws IllegalArgumentException {
		OptionalDouble
			.of(
				OptionalDouble.of(amount) // wrap into Optional
					.stream() // to Stream
					.filter(isPositiveOrZero()) //accept only positive values
					.findFirst() //to Optional
					//raise exception if filter limit results
					.orElseThrow(newIllegalArgumentException("Amount to deposit must not be negative."))
			)
			// execute consumer action (increment funds)
			.ifPresent(x -> funds.updateAndGet((Double current) -> current + x));
	}

	@Override
	public void withdraw(final double amount) throws IllegalArgumentException, IllegalStateException {
		OptionalDouble
			.of(
				OptionalDouble.of(amount) // wrap into Optional
					.stream() // to Stream
					.filter(isPositiveOrZero()) //accept only positive values
					.findFirst() //to Optional
					//raise exception if filter limit results
					.orElseThrow(newIllegalArgumentException("Amount to withdraw must not be negative."))
			)
			// execute consumer action (decrease funds)
			.ifPresent(
					x -> funds.updateAndGet(
							(Double current) -> current - OptionalDouble.of(x) // wrap into Optional
								.stream() // to Stream
								//accept only target positive funds
								.filter(hasSufficientFunds(current))
								.findFirst() //to Optional
								//raise exception if filter limit results
								.orElseThrow(newIllegalStateException("Insufficient funds."))
							)
				);
	}

	@Override
	public double getFunds() {
		return this.funds.get();
	}


	private static DoublePredicate isPositiveOrZero() {
		return x -> Double.compare(x, 0) >= 0;
	}

	private static DoublePredicate hasSufficientFunds(double current) {
		return x -> Double.compare(current - x, 0) >= 0;
	}

	private static Supplier<? extends IllegalArgumentException> newIllegalArgumentException(String message) {
		return () -> new IllegalArgumentException(message);
	}

	private static Supplier<? extends IllegalStateException> newIllegalStateException(String message) {
		return () -> new IllegalStateException(message);
	}
}
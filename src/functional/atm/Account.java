package functional.atm;

import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicReference;

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
					.filter(x -> Double.compare(x, 0) >= 0) //accept only positive values
					.findFirst() //to Optional
					.orElseThrow(() -> new IllegalArgumentException("Amount to deposit must not be negative."))
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
					//accept only positive values
					.filter(x -> Double.compare(x, 0) >= 0)
					.findFirst() //to Optional
					//raise exception if filter limit results
					.orElseThrow(() -> new IllegalArgumentException("Amount to withdraw must not be negative."))
			)
			// execute consumer action (increment funds)
			.ifPresent(
					x -> funds.updateAndGet(
							(Double current) -> current - OptionalDouble.of(x) // wrap into Optional
								.stream() // to Stream
								//accept only target positive funds
								.filter(value -> Double.compare(current - value, 0) >= 0)
								.findFirst() //to Optional
								//raise exception if filter limit results
								.orElseThrow(() -> new IllegalStateException("Insufficient funds."))
							)
				);
	}

	@Override
	public double getFunds() {
		return this.funds.get();
	}
}
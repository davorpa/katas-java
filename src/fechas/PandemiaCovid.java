/**
 *
 */
package fechas;

import java.time.LocalDate;

/**
 * Dado un conjunto de fechas, mostrar cuales son previas y cuales posteriores a la pandemia de COVID19.
 *
 * @author davorpa
 */
public class PandemiaCovid
{
	private static final LocalDate COVID_INITIAL_DATE = LocalDate.of(2020, 5, 15);
	private static final LocalDate COVID_END_DATE = LocalDate.of(2021, 5, 9);


	public static void main(String[] args) {

		LocalDate[] dates = {
			LocalDate.of(2019, 5, 1),
			LocalDate.of(2021, 1, 1),
			LocalDate.of(2022, 1, 1),
			LocalDate.of(2020, 5, 15),
			LocalDate.of(2021, 5, 9),
		};
		testCompareDate(dates);
	}


	static void testCompareDate(LocalDate[] dates) {
		for (LocalDate date : dates) {
			PandemiaDateType type = compareDate(date);
			switch (type) {
				case BEFORE:
					System.out.println(date + " es anterior a las fechas de la pandemia COVID en España");
					break;
				case AFTER:
					System.out.println(date + " es posterior a las fechas de la pandemia COVID en España");
					break;
			}
		}
	}


	static PandemiaDateType compareDate(LocalDate date) {
		if (COVID_INITIAL_DATE.isAfter(date) || COVID_INITIAL_DATE.isEqual(date)) {
			return PandemiaDateType.BEFORE;
		}
		if (COVID_END_DATE.isBefore(date) || COVID_END_DATE.isEqual(date)) {
			return PandemiaDateType.BEFORE;
		}
		return PandemiaDateType.INSIDE;
	}


	public enum PandemiaDateType {
		BEFORE,
		INSIDE,
		AFTER
	}
}

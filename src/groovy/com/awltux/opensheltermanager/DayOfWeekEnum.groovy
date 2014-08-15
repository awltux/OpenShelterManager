package com.awltux.opensheltermanager
import java.util.Calendar

enum DayOfWeekEnum {
	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY)
	
	private final Integer id
	
	public DayOfWeekEnum(Integer id){
		this.id = id
	}

	public Date firstAfter(Date startDate){
		Calendar startCalendar = Calendar.getInstance()
		startCalendar.setTime(startDate)
		Integer startDay = startCalendar.get(Calendar.DAY_OF_WEEK)
		// allow for start day being later in the week than the end day
		Integer endDay = ( startDay > id ) ? (id + 7) : id
		Integer daysUntilThisDay =  endDay - startDay 
		startCalendar.add(Calendar.DAY_OF_MONTH,daysUntilThisDay)
		return startCalendar.getTime()
	}

	public Date lastBefore(Date endDate){
		Calendar endCalendar = Calendar.getInstance()
		endCalendar.setTime(endDate)
		Integer endDay = endCalendar.get(Calendar.DAY_OF_WEEK)
		Integer daysBeforeThisDay = id - endDay - 7
		endCalendar.add(Calendar.DAY_OF_MONTH,daysBeforeThisDay)
		return endCalendar.getTime()
	}

	public Date lastBefore(Date startDate, Date endDate, Integer skipWeeks=1){
		Calendar endCalendar = Calendar.getInstance()
		endCalendar.setTime(endDate)
		Integer endDay = endCalendar.get(Calendar.DAY_OF_WEEK)
		Integer daysBeforeThisDay = id - endDay - 7
		endCalendar.add(Calendar.DAY_OF_MONTH,daysBeforeThisDay)
		return endCalendar.getTime()
	}

	public Integer countWeeks(Date startDate, Date endDate){
		Date firstOccurance = firstAfter(startDate)
		Integer weeksCounted = 0
		if(firstOccurance <= endDate ){
			weeksCounted = ((endDate - firstOccurance) / 7)
		}
		return weeksCounted
	}

	public Integer countDaysUntilLast(Date startDate, Date endDate, Integer skipWeeks=1){
		Date today = new Date()
		Integer paymentDayOfWeekCount = countWeeks(startDate, endDate)
		Integer withinPaymentSchedule = (paymentDayOfWeekCount / skipWeeks )
		Date firstOccurance = firstAfter(startDate)
		Integer daysCounted = 0
		final Integer daysBeforeFirstOccurance = (firstOccurance <= today) ? (firstOccurance - startDate) : 0
		daysCounted = daysBeforeFirstOccurance + ( withinPaymentSchedule * skipWeeks * 7 )
		return daysCounted
	}

	public static DayOfWeekEnum getDayOfWeek(Integer index){
		DayOfWeekEnum matched = null
		for (item in values()) {
			if(item.id == index){
				matched = item
			}
		}
		return matched
	}
}

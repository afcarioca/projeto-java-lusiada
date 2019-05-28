package pt.com.praxe.projeto;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendario {
	
	Calendar dateOfBirth;
	Calendar today;
	public Calendario() {
		this.dateOfBirth = new GregorianCalendar();
	}
	
	public void setDataNascimento(Date date){
		this.dateOfBirth.setTime(date);
	}
	
	public Calendar getDataAtual() {
		return Calendar.getInstance();
	}
	
	public int getToday() {
		return this.today.get(Calendar.YEAR);
	}
	
	public int getDateOfBirth() {
		return this.dateOfBirth.get(Calendar.YEAR);
	}
	
	public Integer getIdade() {
		int age = this.getToday() - this.getDateOfBirth();
		this.dateOfBirth.add(Calendar.YEAR, age);
		
		if(this.today.before(this.dateOfBirth))
			age--;
		
		return age;
	}
}

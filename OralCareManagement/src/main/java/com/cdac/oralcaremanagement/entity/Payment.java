package com.cdac.oralcaremanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_table")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pay_id", nullable = false)
	private long payId;

	@Column(name = "p_date")
	private LocalDate date;

	private int amount;

	@OneToOne
	@JoinColumn(name = "appt_id")
	private Appointment apptId;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(long payId, LocalDate date, int amount, Appointment apptId) {
		super();
		this.payId = payId;
		this.date = date;
		this.amount = amount;
		this.apptId = apptId;
	}

	public long getPayId() {
		return payId;
	}

	public void setPayId(long payId) {
		this.payId = payId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Appointment getApptId() {
		return apptId;
	}

	public void setApptId(Appointment apptId) {
		this.apptId = apptId;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", date=" + date + ", amount=" + amount + ", apptId=" + apptId + "]";
	}

}

package com.pavlenty.Ipotekav3;

import java.text.DecimalFormat;

public class Mortgage {

  private float amount;
  private int years;
  private float rate;

  public final DecimalFormat MONEY = new DecimalFormat( "#,##0.00" );

  public float getRate() {
    return rate;
  }

  public void setRate( float newRate ) {
    if( newRate >= 0 )
      rate = newRate;
  }

  public void setAmount( float newAmount ) {
    if( newAmount >= 0 )
      amount = newAmount;
  }

  public void setYears( int newYears ) {
    if( newYears >= 0 )
      years = newYears;
  }

  public float getAmount( ) {
    return amount;
  }

  public String getFormattedAmount( ) { return MONEY.format(amount); }

  public int getYears( ) {
    return years;
  }


  public double monthlyPayment( ) {
    float mRate = rate / 12;
    double temp = Math.pow(( 1 + mRate ), years * 12 );
    return amount * (mRate * temp / (temp - 1));
  }

  public String formattedMonthlyPayment( ) {
    return MONEY.format( monthlyPayment( ) );
  }

  public double totalPayment( ) {
    return monthlyPayment( ) * years * 12;
  }

  public String formattedTotalPayment( ) {
    return MONEY.format( totalPayment( ) );
  }
}
package com.solid.i.good;

import com.solid.i.ComplexInvoice;

public class GoodComplexInvoicePrinter implements GoodComplexInvoicePrinter_I
{

	@Override
	public void printComplexInvoice(ComplexInvoice complexInvoice) {
		System.out.println("Printing complex invoice " + complexInvoice);
	}
}
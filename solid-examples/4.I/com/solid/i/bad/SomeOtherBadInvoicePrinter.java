package com.solid.i.bad;

import com.solid.i.ComplexInvoice;
import com.solid.i.Invoice;

public class SomeOtherBadInvoicePrinter implements BadInvoicePrinter_I {

	@Override
	public void print(Invoice invoice) {
		// not needed here
	}

	@Override
	public void printComplexInvoice(ComplexInvoice complexInvoice) {
		System.out.println("Printing complex invoice in a totally different way "
			+ complexInvoice);
	}

	@Override
	public void someOtherPrintMethod(Invoice invoice) {
		// not needed here
	}
}
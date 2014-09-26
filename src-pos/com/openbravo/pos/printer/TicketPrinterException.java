//    WandaPos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of WandaPos
//
//    WandaPos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   WandaPos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with WandaPos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.printer;

/**
 *
 * @author JG uniCenta
 */
public class TicketPrinterException extends java.lang.Exception {

    /**
     *
     */
    public TicketPrinterException() {
    }

    /**
     *
     * @param msg
     */
    public TicketPrinterException(String msg) {
        super(msg);
    }

    /**
     *
     * @param msg
     * @param cause
     */
    public TicketPrinterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}



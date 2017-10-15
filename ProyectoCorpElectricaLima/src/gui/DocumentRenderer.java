// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 12/01/2011 09:58:43 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DocumentRenderer.java

package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DocumentRenderer
    implements Printable
{

    public DocumentRenderer()
    {
        currentPage = -1;
        pageEndY = 0.0D;
        pageStartY = 0.0D;
        scaleWidthToFit = true;
        pFormat = new PageFormat();
        pJob = PrinterJob.getPrinterJob();
    }

    public Document getDocument()
    {
        if(jeditorPane != null)
            return jeditorPane.getDocument();
        else
            return null;
    }

    public boolean getScaleWidthToFit()
    {
        return scaleWidthToFit;
    }

    public void pageDialog()
    {
        pFormat = pJob.pageDialog(pFormat);
    }

    public int print(Graphics g, PageFormat pageformat, int i)
    {
        double d = 1.0D;
        Graphics2D graphics2d = (Graphics2D)g;
        jeditorPane.setSize((int)pageformat.getImageableWidth(), 0x7fffffff);
        jeditorPane.validate();
        View view = jeditorPane.getUI().getRootView(jeditorPane);
        if(scaleWidthToFit)
        {
            d = pageformat.getImageableWidth() / jeditorPane.getMinimumSize().getWidth();
            graphics2d.scale(d, d);
        }
        graphics2d.setClip((int)(pageformat.getImageableX() / d), (int)(pageformat.getImageableY() / d), (int)(pageformat.getImageableWidth() / d), (int)(pageformat.getImageableHeight() / d));
        if(i > currentPage)
        {
            currentPage = i;
            pageStartY += pageEndY;
            pageEndY = graphics2d.getClipBounds().getHeight();
        }
        graphics2d.translate(graphics2d.getClipBounds().getX(), graphics2d.getClipBounds().getY());
        Rectangle rectangle = new Rectangle(0, (int)(-pageStartY), (int)jeditorPane.getMinimumSize().getWidth(), (int)jeditorPane.getPreferredSize().getHeight());
        if(printView(graphics2d, rectangle, view))
        {
            return 0;
        } else
        {
            pageStartY = 0.0D;
            pageEndY = 0.0D;
            currentPage = -1;
            return 1;
        }
    }

    public void print(HTMLDocument htmldocument)
    {
        setDocument(htmldocument);
        printDialog();
    }

    public void print(JEditorPane jeditorpane)
    {
        setDocument(jeditorpane);
        printDialog();
    }

    public void print(PlainDocument plaindocument)
    {
        setDocument(plaindocument);
        printDialog();
    }

    public void printHtmlString(String s)
    {
        printHtmlString(s, null);
    }
    
    public void print(JTable tabla)
    {
        setDocument((Document)tabla);
        printDialog();
    }
    
    public void print(JPanel pnlMedio) {
    	setDocument(pnlMedio);
        printDialog();
	}
    
    public void printHtmlString(String s, Dimension dimension)
    {
        HTMLEditorKit htmleditorkit = new HTMLEditorKit();
        HTMLDocument htmldocument = (HTMLDocument)htmleditorkit.createDefaultDocument();
        jeditorPane = new JEditorPane();
        jeditorPane.setEditorKit(htmleditorkit);
        jeditorPane.setDocument(htmldocument);
        jeditorPane.setText(s);
        jeditorPane.setPreferredSize(new java.awt.Dimension(126, 104));
        if(dimension != null)
            setSize(dimension);
        printDialog();
    }

    protected void printDialog()
    {
        if(pJob.printDialog())
        {
            pJob.setPrintable(this, pFormat);
            try
            {
                pJob.print();
            }
            catch(PrinterException printerexception)
            {
                pageStartY = 0.0D;
                pageEndY = 0.0D;
                currentPage = -1;
                System.out.println("Error Printing Document");
            }
        }
    }

    protected boolean printView(Graphics2D graphics2d, Shape shape, View view)
    {
        boolean flag = false;
        Rectangle rectangle = graphics2d.getClipBounds();
        if(view.getViewCount() > 0)
        {
            if(shape.getBounds().getY() >= rectangle.getY() && shape.getBounds().getMaxY() <= rectangle.getMaxY())
                view.paint(graphics2d, shape);
            for(int i = 0; i < view.getViewCount(); i++)
            {
                Shape shape1 = view.getChildAllocation(i, shape);
                if(shape1 != null)
                {
                    View view1 = view.getView(i);
                    if(printView(graphics2d, shape1, view1))
                        flag = true;
                }
            }

        } else
        if(shape.getBounds().getMaxY() >= rectangle.getY())
        {
            flag = true;
            if(shape.getBounds().getHeight() > rectangle.getHeight() && shape.intersects(rectangle))
                view.paint(graphics2d, shape);
            else
            if(shape.getBounds().getY() >= rectangle.getY())
                if(shape.getBounds().getMaxY() <= rectangle.getMaxY())
                    view.paint(graphics2d, shape);
                else
                if(shape.getBounds().getY() < pageEndY)
                    pageEndY = shape.getBounds().getY();
        }
        return flag;
    }

    protected void setContentType(String s)
    {
        jeditorPane.setContentType(s);
    }

    public void setDocument(HTMLDocument htmldocument)
    {
        jeditorPane = new JEditorPane();
        setDocument("text/html", ((Document) (htmldocument)));
    }

    public void setDocument(JEditorPane jeditorpane)
    {
        jeditorPane = new JEditorPane();
        setDocument(jeditorpane.getContentType(), jeditorpane.getDocument());
    }

    public void setDocument(PlainDocument plaindocument)
    {
        jeditorPane = new JEditorPane();
        setDocument("text/plain", ((Document) (plaindocument)));
    }

    protected void setDocument(String s, Document document)
    {
        setContentType(s);
        jeditorPane.setDocument(document);
    }
    /******************************/
    public void setDocument(Document tabla)
    {
        jeditorPane = new JEditorPane();
        setDocument("text/plain", tabla);
    }
    
    public void setDocument(JPanel tabla)
    {
        jeditorPane = new JEditorPane();
        setDocument("text/plain", (Document)tabla);
    }
    
    public void setScaleWidthToFit(boolean flag)
    {
        scaleWidthToFit = flag;
    }

    public void setSize(Dimension dimension)
    {
        jeditorPane.setMinimumSize(new Dimension(dimension));
    }

    protected int currentPage;
    protected JEditorPane jeditorPane;
    protected double pageEndY;
    protected double pageStartY;
    protected boolean scaleWidthToFit;
    protected PageFormat pFormat;
    protected PrinterJob pJob;
	
	
	
    
}
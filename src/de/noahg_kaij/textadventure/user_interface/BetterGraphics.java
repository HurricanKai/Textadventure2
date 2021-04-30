package de.noahg_kaij.textadventure.user_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * A Graphics helper resembling {@link java.awt.Graphics } but with {@link de.noahg_kaij.textadventure.user_interface.ISizeReference} instead of pixels
 * @author Kai Jellinghaus
 */
public final class BetterGraphics {

	private final Graphics _g;
	private final int _width;
	private final int _height;
	private final int _offsetX;
	private final int _offsetY;
	private final Color _color;

	public BetterGraphics(Graphics g) {
		_g = g;
		Rectangle bounds = g.getClipBounds();
		_offsetX = bounds.x;
		_offsetY = bounds.y;
		_width = bounds.width;
		_height = bounds.height;
		_color = g.getColor();
	}
	
	private BetterGraphics(Graphics g, int offsetX, int offsetY, int width, int height, Color color) {
		_g = g;
		_offsetX = offsetX;
		_offsetY = offsetY;
		_width = width;
		_height = height;
		_color = color;
	}

	public void drawArc(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, int startAngle, int arcAngle) {
		_g.setColor(_color);
		_g.drawArc(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), startAngle, arcAngle);
	}

	public boolean drawImage(Image img, ISizeReference x, ISizeReference y, ImageObserver observer) {
		_g.setColor(_color);
		return _g.drawImage(img, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height), observer);
	}

	public boolean drawImage(Image img, ISizeReference x, ISizeReference y, Color bgcolor, ImageObserver observer) {
		_g.setColor(_color);
		return _g.drawImage(img, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height), bgcolor, observer);
	}

	public boolean drawImage(Image img, ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, ImageObserver observer) {
		_g.setColor(_color);
		return _g.drawImage(img, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), observer);
	}

	public boolean drawImage(Image img, ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, Color bgcolor, ImageObserver observer) {
		_g.setColor(_color);
		return _g.drawImage(img, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), bgcolor, observer);
	}

	public void drawLine(ISizeReference x1, ISizeReference y1, ISizeReference x2, ISizeReference y2) {
		_g.setColor(_color);
		_g.drawLine(_offsetX + x1.getValue(_width), _offsetY + y1.getValue(_height), _offsetX + x2.getValue(_width), _offsetY + y2.getValue(_height));
	}

	public void drawOval(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height) {
		_g.setColor(_color);
		_g.drawOval(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height));
	}

	public void drawPolygon(ISizeReference[] xPoints, ISizeReference[] yPoints) throws Exception {
		if (xPoints.length != yPoints.length)
			throw new Exception("array size missmatch");
		int size = xPoints.length;
		int[] arr1 = new int[size];
		int[] arr2 = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			arr1[i] = _offsetX + xPoints[i].getValue(_width);
			arr2[i] = _offsetY + yPoints[i].getValue(_height);
		}
		
		_g.setColor(_color);
		_g.drawPolygon(arr1, arr2, size);
	}

	public void drawPolyline(ISizeReference[] xPoints, ISizeReference[] yPoints) throws Exception {
		if (xPoints.length != yPoints.length)
			throw new Exception("array size missmatch");
		int size = xPoints.length;
		int[] arr1 = new int[size];
		int[] arr2 = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			arr1[i] = _offsetX + xPoints[i].getValue(_width);
			arr2[i] = _offsetY + yPoints[i].getValue(_height);
		}
		
		_g.setColor(_color);
		_g.drawPolyline(arr1, arr2, size);
	}

	public void drawRoundRect(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, ISizeReference arcWidth, ISizeReference arcHeight) {
		_g.setColor(_color);
		_g.drawRoundRect(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), arcWidth.getValue(_width), arcHeight.getValue(_width));
	}
	
	public void drawString(String str, ISizeReference x, ISizeReference y) {
		_g.setColor(_color);
		_g.drawString(str, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height));
	}

	public void drawString(AttributedCharacterIterator iterator, ISizeReference x, ISizeReference y) {
		_g.setColor(_color);
		_g.drawString(iterator, _offsetX + x.getValue(_width), _offsetY + y.getValue(_height));
	}

	public void fillArc(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, int startAngle, int arcAngle) {
		_g.setColor(_color);
		_g.fillArc(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), startAngle, arcAngle);
	}

	public void fillOval(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height) {
		_g.setColor(_color);
		_g.fillOval(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height));
	}

	public void fillPolygon(ISizeReference[] xPoints, ISizeReference[] yPoints) throws Exception {
		if (xPoints.length != yPoints.length)
			throw new Exception("array size missmatch");
		int size = xPoints.length;
		int[] arr1 = new int[size];
		int[] arr2 = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			arr1[i] = _offsetX + xPoints[i].getValue(_width);
			arr2[i] = _offsetY + yPoints[i].getValue(_height);
		}
		
		_g.setColor(_color);
		_g.fillPolygon(arr1, arr2, size);
	}

	public void fillRect(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height) {
		_g.setColor(_color);
		_g.fillRect(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height));
	}

	public void fillRoundRect(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height, ISizeReference arcWidth, ISizeReference arcHeight) {
		_g.setColor(_color);
		_g.fillRoundRect(_offsetX + x.getValue(_width), _offsetY + y.getValue(_height), width.getValue(_width), height.getValue(_height), arcWidth.getValue(_width), arcHeight.getValue(_width));
	}

	public FontMetrics getFontMetrics(Font f) {
		return _g.getFontMetrics(f);
	}

	public BetterGraphics translate(ISizeReference x, ISizeReference y) {
		int absX = x.getValue(_width);
		int absY = y.getValue(_height);
		return new BetterGraphics(_g, _offsetX + absX, _offsetY + absY, _width - absX, _height - absY, _color);
	}

	public BetterGraphics color(Color color)
	{
		return new BetterGraphics(_g, _offsetX, _offsetY, _width, _height, color);
	}
}

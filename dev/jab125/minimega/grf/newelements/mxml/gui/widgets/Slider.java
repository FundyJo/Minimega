package dev.jab125.minimega.grf.newelements.mxml.gui.widgets;

import dev.jab125.minimega.grf.newelements.mxml.IMXml;

public interface Slider extends IMXml, Widgets<Integer> {
  String serializedId();
  
  Integer defaultValue();
  
  Integer[] values();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\grf\newelements\mxml\gui\widgets\Slider.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */
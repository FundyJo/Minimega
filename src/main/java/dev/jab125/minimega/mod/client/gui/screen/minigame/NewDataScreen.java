package dev.jab125.minimega.mod.client.gui.screen.minigame;







import dev.jab125.minimega.mod.util.minigamedata.battle.BattleConfigSettings;import net.minecraft.client.gui.components.AbstractWidget;import java.util.WeakHashMap;import java.util.function.Predicate;import dev.jab125.minimega.mod.util.state.State;import dev.jab125.minimega.grf.newelements.mxml.gui.widgets.Widgets;public class NewDataScreen {

   static public record BooleanValue(boolean b) implements NewDataScreen.Value {}

   public record ButtonData<T>(Predicate<State> statePredicate, Widgets<T> widgets, NewDataScreen.GetterAndSetter<T> getterAndSetter) {}

   public interface GetterAndSetter<T> {
     T get();
     
     void set(T paramT);
   }

   static public record IntegerValue(int i) implements NewDataScreen.Value {}

   public static class StateTracker
   {
     public WeakHashMap<AbstractWidget, NewDataScreen.ButtonData<?>> MAP = new WeakHashMap<>();
     public void startTracking(AbstractWidget b, NewDataScreen.ButtonData<?> data) {
       if (b == null)
         return;  this.MAP.put(b, data);
     }
   }

   interface ThoseArgs<A, B, C>
   {
     BattleConfigSettings create(A paramA, B paramB, C paramC);
     
     default ThoseArgs<C, B, A> reversed() {
       return (c, b, a) -> create((A)a, (B)b, (C)c);
     }
   }

   interface ThoseArgs2<A, B>
   {
     BattleConfigSettings create(A paramA, B paramB);
     
     default ThoseArgs2<B, A> reversed() {
       return (b, a) -> create((A)a, (B)b);
     }
   }

   public interface Value {}
}

package dev.jab125.minimega.grf.newelements.mxml;

public class Tester {

   interface BlockId {}

   static record Leave() implements Tester.BlockId {}

   static record NumericId(int id) implements Tester.BlockId {}

   static record StringId(String id) implements Tester.BlockId {}

   static public record Config(boolean gamemodeLootsetsFixer, boolean blockDefsFixer, boolean gamerulesAddItemFixer) {}
}

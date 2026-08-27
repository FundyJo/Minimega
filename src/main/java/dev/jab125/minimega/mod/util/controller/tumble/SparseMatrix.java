package dev.jab125.minimega.mod.util.controller.tumble;

public class SparseMatrix {
  public record Cell<T>(int x, int z, T value) {}
}

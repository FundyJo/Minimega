package dev.jab125.minimega.mod.util.controller.tumble;

public class SparseTensor {
  public record Cell<T>(int x, int y, int z, T value) {}
}

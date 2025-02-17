The unexpected behavior stems from how `removeIf` interacts with the `Map.Entry` in Maps.  `removeIf` for Maps uses the `Map.Entry` as the parameter for the predicate lambda.  If you try to access the key and value directly from the `it` variable you can perform the removal.  For Maps, it's generally safer and clearer to iterate through the keys and remove entries explicitly using methods like `remove` or `removeAll`.

Here's a safer way to remove even-numbered keys from a `MutableMap`:

```kotlin
fun main() {
    val map = mutableMapOf<Int, String>(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five")
    val keysToRemove = map.keys.filter { it % 2 == 0 }
    map.keys.removeAll(keysToRemove)
    println(map) // Output: {1=one, 3=three, 5=five}
}
```

This approach provides greater clarity and avoids potential confusion related to the `removeIf` function's interaction with Maps.
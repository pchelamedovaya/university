function count(input, max) {
    if (input.value.length > max) {
        input.value = input.value.substring(0, max);
    }
}
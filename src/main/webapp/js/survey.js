function count(inputF, counterE, max) {
    const input = document.getElementById(inputF);
    const counter = document.getElementById(counterE);
    input.addEventListener('input', function () {
        const currentLength = input.value.length;
        counter.textContent = currentLength;
        if (currentLength > max) {
            input.value = input.value.substring(0, max);
            counter.textContent = max;
        }
    });
}
count('comments', 'commentsCount', 440);
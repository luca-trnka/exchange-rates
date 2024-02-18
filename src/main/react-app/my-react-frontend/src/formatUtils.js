export function formatNumber(value) {
    if (value === 0) {
        return "-";
    }
    return value.toString().replace(".", ",");
}

export function displayValue(value) {
    return value === 0 ? "-" : formatNumber(value);
}
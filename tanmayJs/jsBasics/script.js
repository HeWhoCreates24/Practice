let n = prompt("Enter a number");
let nums = [];
for (let i = 0; i < n; i++){
    nums.push(i+1);
}

let sum = nums.reduce((ans, curr) => {
    return ans+curr;
});

let prod = nums.reduce((ans, curr) => {
    return ans*curr;
});

console.log(sum, prod)
// let arr = [87, 89, 95, 79, 82, 92, 90, 91, 75, 81];
// console.log(arr.filter((val) => {
//     return val >= 90;
// }));

// let arr = [1, 2, 3, 4, 5];
// arr.forEach((val) => {
//     console.log(val*val);
// });

// num = prompt("Enter a number :");
// if (num % 5 === 0){
//     alert(num + " is divisible by 5");
// }
// else {
//     alert(num + " is NOT divisible by 5")
// }

// const vowelCount = (str) => {
//     let count = 0;
//     for (let ch of str){
//         switch (ch) {
//             case 'a' :
//             case 'e' :
//             case 'i' :
//             case 'o' :
//             case 'u' :
//                 count++;
//                 break;
//             default :
//         }
//     }
//     return count;
// }
//Helper function for the README file

var qNum = "2315. Count Asterisks";

var link = "https://leetcode.com/problems/count-asterisks/";

function READMELINK() {
    var arr = qNum.split(" ");
    var num = arr[0].slice(0, arr[0].length - 1);
    var qName = arr.slice(1);

    var readme = `${num} | [${qName.join(" ")}]`;
    readme += `(${link})`;
    readme += ` | [Java](./Leetcode/${num}.%20${qName.join("%20")}/Solution.java)`;

    return readme;
}

console.log(READMELINK());
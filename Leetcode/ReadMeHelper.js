//Helper function for the README file

function READMELINK(qNum) {
    var arr = qNum.split(" ");
    var num = arr[0].slice(0, arr[0].length - 1);
    var qName = arr.slice(1);

    var readme = `${num} | [${qName.join(" ")}]`;
    readme += `(https://leetcode.com/problems/${qName.join("-")}/)`;
    readme += ` | [Java](./Leetcode/${num}.%20${qName.join("%20")}/Solution.java)`;

    console.log(readme);
}

READMELINK("2260. Minimum Consecutive Cards to Pick Up");
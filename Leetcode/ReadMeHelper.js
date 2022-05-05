//Helper function for the README file

function READMELINK(qNum) {
    var qNum = "2124. Check if All A's Appears Before All B's";
    var link = "https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/";

    var arr = qNum.split(" ");
    var num = arr[0].slice(0, arr[0].length - 1);
    var qName = arr.slice(1);

    var readme = `${num} | [${qName.join(" ")}]`;
    readme += `${link}/)`;
    readme += ` | [Java](./Leetcode/${num}.%20${qName.join("%20")}/Solution.java)`;

    console.log(readme);
}

READMELINK();
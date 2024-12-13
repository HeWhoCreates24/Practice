let p = document.querySelector("p");
p.classList.add("changeColor");

const body = document.querySelector("div");
for (let i = 0; i < 3; i++){
    body.innerHTML += `<div class="box">box ${i+1}</div>\n`
}

let newButton = document.createElement("button");
newButton.innerHTML = `<b>CLICK ME!</b>`;
newButton.style.backgroundColor = "red";
newButton.style.color = "white";
document.querySelector("body div").prepend(newButton);
let btn = document.querySelector("button");
btn.addEventListener("click", () => {
    let rootStyle = getComputedStyle(document.documentElement);
    if (rootStyle.getPropertyValue("--theme").trim() === "light"){
        document.documentElement.style.setProperty("--c1", "darkblue");
        document.documentElement.style.setProperty("--c2", "darkgreen");
        document.documentElement.style.setProperty("--c3", "white");
        document.documentElement.style.setProperty("--c4", "black");
        document.documentElement.style.setProperty("--theme", "dark");
    }
    else{
        document.documentElement.style.setProperty("--c1", "pink");
        document.documentElement.style.setProperty("--c2", "lightblue");
        document.documentElement.style.setProperty("--c3", "black");
        document.documentElement.style.setProperty("--c4", "white");
        document.documentElement.style.setProperty("--theme", "light");
    }
})
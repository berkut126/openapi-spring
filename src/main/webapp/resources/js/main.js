const one = document.querySelector("#one");
const two = document.querySelector("#two");
const stuff = document.querySelector(".stuff");
const username = document.querySelector(".username");
const user = document.querySelector(".user");
const rights = document.querySelector("#rights");
const block = document.querySelector("#block");
const submit = document.querySelector("#submit");
const file = document.querySelector(".file");
const storage = document.querySelector(".storage");
const code = document.querySelector(".code");
const remove = document.querySelector("#delete");


window.onload = (() => {

    document.querySelectorAll("input[type=range]").forEach((it) => {
        it.addEventListener("click", inverse);
    });

    document.querySelectorAll(".classFile").forEach((it) => {
        it.addEventListener("click", fileClicked);
    });

    document.querySelectorAll(".username").forEach((it) => {
        it.addEventListener("click", userClicked);
    });

    one.addEventListener("click", showSystem);
    two.addEventListener("click", showStorage);

});

function inverse() {
    this.value = this.value === "0" ? "1" : "0";
}

function showStorage() {
    stuff.style.display = "flex";
    user.style.display = "none";
    file.style.display = "none";
    storage.style.display = "none";
}

function showSystem(){
    stuff.style.display = "none";
    user.style.display = "none";
    file.style.display = "none";
    storage.style.display = "flex";
}

function fileClicked() {
    user.style.display = "none";
    storage.style.display = "none";
    file.style.display = "flex";
    $.get("/algoCode/"+this.id+"/code", (res) => {
        code.innerText = res;
    })
}

function userClicked() {
    user.style.display = "flex";
    storage.style.display = "none";
    file.style.display = "none";
    $.get("/user/"+this.innerText, (res) => {
        rights.value = res.rights;
        block.value = res.blocked ? "1" : "0";
    });
    submit.onclick = (ev) => {
        if(remove.checked){
            $.ajax({
                url: "/user/"+this.innerText,
                type: "DELETE"
            });
        } else {
            $.ajax({
                url: "/user/"+this.innerText,
                type: "PUT",
                data: JSON.stringify({
                    rights: rights.value,
                    blocked: block.value === "1"
                })
            });
        }
    };
}
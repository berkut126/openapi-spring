const file = document.querySelector(".file");
const remove = document.querySelector("#delete");
const hidden = document.querySelector(".hidden");

window.onload = (() => {
    document.querySelectorAll(".classFile").forEach((it) => {
        it.addEventListener("click", fileClicked);
    });
    remove.addEventListener("click", deleteFile);
});

function deleteFile() {
    $.ajax({
        url: "/algoCode/"+this.innerText,
        type: "DELETE"
    });
}

function fileClicked() {
    $.get("/algoCode/"+this.id+"/code", (res) => {
        code.innerHTML = hljs.highlight("java", res, true);
    });
    hidden.value = this.id;
}
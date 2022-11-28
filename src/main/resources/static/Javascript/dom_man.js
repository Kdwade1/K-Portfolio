
const checkbox= document.getElementById("checkbox")

checkbox.addEventListener('change',()=>{
document.body.classList.toggle('dark')
})
function openNav() {
    document.getElementById("mySidepanel").style.width = "250px";
}

/* Set the width of the sidebar to 0 (hide it) */
function closeNav() {
    document.getElementById("mySidepanel").style.width = "0";
}

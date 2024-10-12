console.log("Script Loaded");

let currenttheme=gettheme();
console.log(currenttheme);
Changethem();
function Changethem(){
    //set to web page
    document.querySelector("html").classList.add(currenttheme);

    //set the listner
    const changethemebutton=document.querySelector('#theme_change_button')
    changethemebutton.addEventListener("click",(event)=>{
        console.log("Changetheme button clicked");
        document.querySelector("html").classList.remove(currenttheme);
        if(currenttheme=="dark"){
            currenttheme="light"
        }
        else{
            currenttheme="dark"
        }
        //local storage update 
        settheme(currenttheme);
        document.querySelector("html").classList.add(currenttheme);
    })

}

//settheme
function settheme(theme){
    localStorage.setItem("theme",theme);
}
//gettheme
function gettheme(){
    let theme= localStorage.getItem("theme");
    if(theme) return theme;
    else return "dark";

}
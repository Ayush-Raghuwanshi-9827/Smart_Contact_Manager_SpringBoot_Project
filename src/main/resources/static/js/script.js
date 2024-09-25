console.log("Script Loaded")

let currentTheme = getTheme();
changeTheme(currentTheme)

function changeTheme(){
//   set to web page
document.querySelector('html').classList.add(currentTheme);


//set the listener to change theme button
const changeThemeButton = document.querySelector('#theme_change_button')
changeThemeButton.querySelector('span').textContent = currentTheme=="light"?"Dark":"Light";
changeThemeButton.addEventListener("click", (event) => {
    const oldTheme= currentTheme;
    if(currentTheme === "dark"){
         currentTheme = "light";
     }
    else currentTheme = "dark";
    setTheme(currentTheme);
    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(currentTheme);

//    change the text of button
       changeThemeButton.querySelector('span').textContent = currentTheme=="light"?"Dark":"Light";
   });

}


//set theme to local Storage
function setTheme(theme){
  localStorage.setItem("theme", theme);
}

//get theme to local Storage
function getTheme(){
  let theme = localStorage.getItem("theme");
  if(theme) return theme;
  else return "light";
}
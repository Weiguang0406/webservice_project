window.onload = function () {
  const signupBtn = document.getElementById("signupbtn");
  const signinBtn = document.getElementById("signinbtn");
  const signupModal = document.getElementById("signupbox");
  const signinModal = document.getElementById("signinbox");
  console.log(signinModal);
  console.log(signinBtn);
  const navToggle = document.querySelector(".mobile-nav-toggle");

  signupBtn.addEventListener("click", () => {
    signinModal.classList.add("data-visible");
    // let visibility = signupModal.getAttribute("data-visible");
    // console.log(visibility);
    // if (visibility === "false") {
    //   signupModal.setAttribute("data-visible", true);
    //   signupModal.classList.remove("data-visible");
    //   // navToggle.setAttribute(aria - expanded, "true");
    // } else if (visibility === "true") {
    //   signupModal.setAttribute("data-visible", false);
    //   signupModal.classList.add("data-visible");
    //   // navToggle.setAttribute(aria - expanded, "false");
    // }

    signupModal.classList.toggle("data-visible");
  });

  signinBtn.addEventListener("click", () => {
    // signupModal.setAttribute("data-visible", false);
    signupModal.classList.add("data-visible");

    signinModal.classList.toggle("data-visible");
  });
};

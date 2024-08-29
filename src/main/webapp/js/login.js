// script.js

const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const passwordVisibilityToggle = document.getElementById('password-visibility-toggle');
const darkModeToggle = document.getElementById('dark-mode-toggle');
const lightModeToggle = document.getElementById('light-mode-toggle');
const loginBtn = document.getElementById('login-btn');

// Email input validation
emailInput.addEventListener('input', () => {
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });
    if (!emailInput.validity.valid) {
        const errorMessage = emailInput.parentNode.querySelector('.error-message');
        errorMessage.textContent = 'Invalid email address';
    }
});

// Password input validation
passwordInput.addEventListener('input', () => {
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });
    if (!passwordInput.validity.valid) {
        const errorMessage = passwordInput.parentNode.querySelector('.error-message');
        errorMessage.textContent = 'Password must be at least 8 characters long';
    }
});

// Password visibility toggle
passwordVisibilityToggle.addEventListener('click', () => {
    const passwordInputType = passwordInput.type;
    if (passwordInputType === 'password') {
        passwordInput.type = 'text';
        passwordVisibilityToggle.innerHTML = '<i class="material-icons">visibility_off</i>';
    } else {
        passwordInput.type = 'password';
        passwordVisibilityToggle.innerHTML = '<i class="material-icons">visibility</i>';
    }
});

// Dark mode toggle
darkModeToggle.addEventListener('click', () => {
    document.body.classList.add('dark-mode');
    darkModeToggle.style.display = 'none';
    lightModeToggle.style.display = 'block';
});

// Light mode toggle
lightModeToggle.addEventListener('click', () => {
    document.body.classList.remove('dark-mode');
    lightModeToggle.style.display = 'none';
    darkModeToggle.style.display = 'block';
});

// Login button loading animation
loginBtn.addEventListener('click', () => {
    const loadingAnimation = document.createElement('div');
    loadingAnimation.classList.add('loading-animation');
    loadingAnimation.innerHTML = '<i class="material-icons">refresh</i>';
    loginBtn.appendChild(loadingAnimation);
    setTimeout(() => {
        loadingAnimation.remove();
    }, 2000);
});
const firstName = document.getElementById('firstName').value;
const lastName = document.getElementById('lastName').value;
const phone = document.getElementById('phone').value;
const description = document.getElementById('description').value;

document.getElementById('resetProfileButton').addEventListener('click', () => {
    document.getElementById('firstName').value = firstName;
    document.getElementById('lastName').value = lastName;
    document.getElementById('phone').value = phone;
    document.getElementById('description').value = description;
});
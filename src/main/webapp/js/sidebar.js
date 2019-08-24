const loadAjax = (ajaxUrl, title, url) => {
    history.pushState({}, title, url);

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = () => {
        if (xhttp.status === 200) {
            document.getElementById('content').innerHTML = xhttp.responseText;
        }
    };

    xhttp.open("GET", ajaxUrl, true);
    xhttp.send();
};

document.getElementById('view-link').addEventListener('click',
    () => loadAjax('/ajax/content/list', 'View Content', '/list'));
document.getElementById('form-link').addEventListener('click',
    () => loadAjax('/ajax/content/form', 'Form Content', '/form'));
document.getElementById('profile-link').addEventListener('click',
    () => loadAjax('/ajax/account/profile', 'Profile', '/profile'));




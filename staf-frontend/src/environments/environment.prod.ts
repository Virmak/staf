export const environment = {
  production: true,
  resolveApi: () => {
    const urlArr = window.location.href.split('/');
    if (urlArr[2].indexOf('4200') > -1) {
      urlArr[2] = urlArr[2].replace('4200', '8080');
    }
    return urlArr[0] + '//' + urlArr[2];
  }
};

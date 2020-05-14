export const environment = {
  production: true,
  resolveApi: () => {
    const urlArr = window.location.href.split('/');
    return urlArr[0] + '//' + window.location.href.split('/')[2].replace(/:\d+/, ':6500');
  },
  resolveWebSocket: () => {
    const urlArr = window.location.href.split('/');
    return 'ws://' + urlArr[2] + ':15674/ws'
  },
  webSocket: () => {
    const urlArr = window.location.href.split('/');
    return urlArr[0] + '//' + window.location.href.split('/')[2].replace(/:\d+/, ':6500') + '/staf-ws'
  }
};

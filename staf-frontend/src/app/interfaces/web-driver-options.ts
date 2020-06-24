export interface IWebDriverOptions {
    webDriverAddress: string;
    browserName: string;
    browserVersion: string;
    remote: boolean;
    enableVnc: boolean;
    enableVideo: boolean;
    sessionCount: number;
    runInSelenoid?: boolean;
}
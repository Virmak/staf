export interface IGetReportsResponse {
    projectName: string;
    reportsFileNameList: GetReportItemResponse[];
}

export interface GetReportItemResponse {
    fileName: string;
    path: string;
}
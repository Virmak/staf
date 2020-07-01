export interface ITestCase {
    name: string;
    path: string;
    ignored: boolean;
    order: number;
    enabled?: boolean;
}
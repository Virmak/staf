import { IUser } from './iuser';

export interface IAuthResponse extends IUser {
    token: string;
}
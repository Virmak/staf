export interface IUser {
    id: number;
    username: string;
    email: string;
    name: string;
    roles: UserRole[];
}

export enum UserRole {
    ADMIN,
    USER
}
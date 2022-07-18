declare global{
    interface SafMediastore{
        selectFolder(uri:string):Promise<string>,
        selectFile(uri:string):Promise<string>,
        openFolder(uri:string):Promise<void>,
        openFile(uri:string):Promise<void>,
        readFile(uri:string):Promise<ArrayBuffer>,
        writeFile({
            data:ArrayBuffer,
            filename:string,
            folder?:string,
            subfolder?:string
        }):Promise<string>,
        saveFile({
            data:ArrayBuffer,
            filename?:string,
            folder?:string
        }):Promise<string>
    }

    interface Window{
        safMediastore:SafMediastore;
    }

    export const safMediastore:SafMediastore;
}
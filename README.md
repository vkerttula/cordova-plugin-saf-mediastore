# cordova-plugin-saf-mediastore

## Read and save files using the Storage Access Framework and Mediastore

This plugin allows you to read and save files using the Storage Access Framework and Mediastore on Android only.

## Available methods

```typescript
selectFolder(uri:string):Promise<string>
```
Launches an Intent to select a folder to which files can be saved. Returns the content URI.

```typescript
selectFile(uri:string):Promise<string>
```
Launches an Intent to select a file. Returns the content URI.

```typescript
openFolder(uri:string):Promise<void>
```
Launches an Intent to open a folder in the folder picker.

```typescript
openFile(uri:string):Promise<void>
```
Launches an Intent to open a file.

```typescript
readFile(uri:string):Promise<ArrayBuffer>
```
Reads a file as a Blob.

```typescript
writeFile({
	data:ArrayBuffer,
	filename:string,
	folder?:string,
	subfolder?:string
}):Promise<string>
```
Writes a file to a specific filename, with the folder and subfolder being optional. The subfolder will be created if it does not exist, and the default folder is the Downloads folder. Returns the content URI.

```typescript
saveFile({
	data:ArrayBuffer,
	filename?:string,
	folder?:string
}):Promise<string>
```
Launches a file picker Intent to save a file, with the preferred filename and folder being optional. Returns the content URI.

To call methods:
```
window.safMediastore.<function>(params); //returns a Promise
await window.safMediastore.<function>(params); //in an async function
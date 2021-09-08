# kubectl

kubectl 명령어 및 설정에 대해 정리합니다.



## #0 명령어

- 컨텍스트 리스트 출력하기

```
$ kubectl config get-contexts
```

- 현재 context 확인하기

```
$ kubectl config current-context
```

- 전체 pod 가져오기

```
$ kubectl get pod -n [namespace]
```



## #1 kubeconfig 설정

- Lens 또는 k8s dashboard 사용을 위해 kubeconfig 설정을 구성합니다.

### 사전 준비

- Lens (k8s IDE) 다운로드
  - https://k8slens.dev/
- GitHub access token 생성
  - https://github.kakaocorp.com/settings/tokens
  - admin:org -> read:org 체크 후 토큰 생성
- dashboard - namespace 권한신청
  - 접근하고자 하는 namespace 권한 신청(GitHub organization)

### kubeconfig 설정

- kubectl 설치

  - https://kubernetes.io/ko/docs/tasks/tools/

  ```
  $ brew install kubectl
  $ kubectl version --client
  ```

- ~/.kube/config (context 파일) 생성

  - ~/.kube 디렉토리에 config 파일이 존재하지 않으면 새로 생성한다.

  ```
  $ vi $HOME/.kube/config
  ```

- config 파일에 k8s cluster 인증값 입력

  ```
  apiVersion: v1
  clusters:
  - cluster:
      certificate-authority-data: TESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdata
      server: https://sandbox-k8s-master.pay.com
    name: pay-k8s	# cluster-name
  ```

- GitHub access token으로 클러스터 인증

  ```
  $ export GITHUB_TOKEN={my-generated-token}
  $ source ~/.zshrc
  $ kubectl config set-credentials [githubUserName] --token $TOKEN
  ex.) kubectl config set-credentials henry-yoon --token $GITHUB_TOKEN
  ```

- 생성한 user로 컨텍스트 설정

  ```
  $ kubectl config set-context [contextName] --cluster [clusterName] --user [githusUserName]
  ex.) kubectl config set-context sandbox --cluster pay-k8s --user henry-yoon
  ```

- 현재 컨텍스트로 변경 (kubectx 플러그인 설치 후 더욱 편하게 context switch 하여 사용할 수 있다.)

  ```
  $ kubectl config use-context [contextName]
  ex.) kubectl config use-context henry-yoon
  
  $ kubectx
  ```

- 전체 컨텍스트 및 현재 컨텍스트 확인

  ```
  $ kubectl config get-contexts
  $ kubectl config current-context
  ```

- 현재 컨텍스트의 namespace의 pod 목록 가져와보기

  ```
  $ kubectl get pod -n [namespace]
  ex.) kubectl get pod -n quattro
  ```

- 적용 완료 후 config 값 예시

  ```
  apiVersion: v1
  clusters:
  - cluster:
      certificate-authority-data: TESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdataTESTDATAtestdata
      server: https://sandbox-k8s-master.pay.com
    name: pay-k8s	# cluster-name
  contexts:
  - context:
      cluster: pay-k8s
      user: henry-yoon
    name: sandbox
  current-context: sandbox
  kind: Config
  preferences: {}
  users:
  - name: henry-yoon
    user:
      token: MyGeneratedTokenMyGeneratedToken
  ```

- Lens 실행 후 config 파일 연결

  ![image](https://user-images.githubusercontent.com/58318041/132437876-1e576957-d346-4127-871c-0428511f1a90.png)

### 주의사항

- 윈도우 환경에 kubectl 설치 시 $HOME 디렉토리에 설치해야 명령어가 동작한다. 특정 디렉토리에 파일을 설치하면 해당 디렉토리 내에서만 kubectl 명령어가 동작한다.



## References

- 업데이트 예정

